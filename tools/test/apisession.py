# Copyright 2012 Citrix Systems, Inc. Licensed under the
# Apache License, Version 2.0 (the "License"); you may not use this
# file except in compliance with the License.  Citrix Systems, Inc.
# reserves all rights not expressly granted by the License.
# You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
# 
# Automatically generated by addcopyright.py at 04/03/2012
import cookielib
import hashlib
import json
import os
import random
import sys
import urllib2
import urllib


class ApiSession:
    """an ApiSession represents one api session, with cookies."""
    def __init__(self, url, username, password):
        self._username = username
        self._password = hashlib.md5(password).hexdigest()
        self._url = url
        self._cj = cookielib.CookieJar()
        self._opener = urllib2.build_opener(urllib2.HTTPCookieProcessor(self._cj))

    def _get(self, parameters):
        encoded = urllib.urlencode(parameters)
        url = "%s?%s"% (self._url, encoded)
        try:
           f = self._opener.open(url)
           return f.read()
        except urllib2.HTTPError as exn:
            print "Command %s failed" % parameters['command']
            print "Reason: %s" % json.loads(exn.read())

    def GET(self, parameters):
        parameters['sessionkey'] = self._sessionkey
        parameters['response'] = 'json'
        return self._get(parameters)
        
    def _post(self,  parameters):
        return self._opener.open(self._url, urllib.urlencode(parameters)).read()

    def POST(self, parameters):
        parameters['sessionkey'] = self._sessionkey
        parameters['response'] = 'json'
        return self._post(parameters)

    def login(self):
        params = {'command':'login', 'response': 'json'}
        params['username'] = self._username
        params['password'] = self._password
        result = self._get(params)
        jsonresult = json.loads(result)
        jsessionid = None
        self._sessionkey = jsonresult['loginresponse']['sessionkey']


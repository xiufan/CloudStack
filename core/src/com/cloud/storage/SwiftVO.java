// Copyright 2012 Citrix Systems, Inc. Licensed under the
// Apache License, Version 2.0 (the "License"); you may not use this
// file except in compliance with the License.  Citrix Systems, Inc.
// reserves all rights not expressly granted by the License.
// You may obtain a copy of the License at http://www.apache.org/licenses/LICENSE-2.0
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
// 
// Automatically generated by addcopyright.py at 04/03/2012
package com.cloud.storage;

import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.cloud.agent.api.to.SwiftTO;
import com.cloud.api.Identity;
import com.cloud.utils.db.GenericDao;

@Entity
@Table(name="swift")
public class SwiftVO implements Swift, Identity {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private long id;
    
    @Column(name="url")
    String url;

    @Column(name="account")
    String account;
    
    @Column(name="username")
    String userName;

    @Column(name="key")
    String key;

    @Column(name="uuid")
    String uuid = UUID.randomUUID().toString();
    
    @Column(name = GenericDao.CREATED_COLUMN)
    private Date created;
        
    public SwiftVO() { }

    public SwiftVO(String url, String account, String userName, String key) {
        this.url = url;
        this.account = account;
        this.userName = userName;
        this.key = key;
    }

    @Override
    public long getId() {
        return id;
    }
    @Override
    public String getUrl() {
        return url;
    }
    @Override
    public String getAccount() {
        return account;
    }
    @Override
    public String getUserName() {
        return userName;
    }
    @Override
    public String getKey() {
        return key;
    }

    public Date getCreated() {
        return created;
    }

    @Override
    public SwiftTO toSwiftTO() {
        return new SwiftTO(getId(), getUrl(), getAccount(), getUserName(), getKey());
    }
    
    @Override
    public String getUuid() {
    	return this.uuid;
    }
    
    public void setUuid(String uuid) {
    	this.uuid = uuid;
    }
}

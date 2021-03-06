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
package com.cloud.hypervisor.vmware.mo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;

import com.cloud.hypervisor.vmware.util.VmwareContext;
import com.vmware.vim25.HttpNfcLeaseInfo;
import com.vmware.vim25.HttpNfcLeaseManifestEntry;
import com.vmware.vim25.HttpNfcLeaseState;
import com.vmware.vim25.ManagedObjectReference;
import com.vmware.vim25.OvfCreateImportSpecResult;
import com.vmware.vim25.OvfFileItem;

public class HttpNfcLeaseMO extends BaseMO {
    private static final Logger s_logger = Logger.getLogger(HttpNfcLeaseMO.class);
	
	public HttpNfcLeaseMO(VmwareContext context, ManagedObjectReference morHttpNfcLease) {
		super(context, morHttpNfcLease);
	}
	
	public HttpNfcLeaseMO(VmwareContext context, String morType, String morValue) {
		super(context, morType, morValue);
	}

	public HttpNfcLeaseState getState() throws Exception {
		return (HttpNfcLeaseState)_context.getServiceUtil().getDynamicProperty(_mor, "state");
	}
	
	public HttpNfcLeaseState waitState(HttpNfcLeaseState[] states) throws Exception {
		assert(states != null);
		assert(states.length > 0);
		
		HttpNfcLeaseState state;
		while(true) {
			state = getState();
			if(state == HttpNfcLeaseState.ready || state == HttpNfcLeaseState.error)
				return state;
		}
	}
	
	public HttpNfcLeaseInfo getLeaseInfo() throws Exception {
		return (HttpNfcLeaseInfo)_context.getServiceUtil().getDynamicProperty(_mor, "info");
	}
	
	public HttpNfcLeaseManifestEntry[] getLeaseManifest() throws Exception {
		return _context.getService().httpNfcLeaseGetManifest(_mor);
	}
	
	public void completeLease() throws Exception {
		_context.getService().httpNfcLeaseComplete(_mor);
	}
	
	public void abortLease() throws Exception {
		_context.getService().httpNfcLeaseAbort(_mor, null);
	}
	
	public void updateLeaseProgress(int percent) throws Exception {
		// make sure percentage is in right range
		if(percent < 0)
			percent = 0;
		else if(percent > 100)
			percent = 100;
		
		_context.getService().httpNfcLeaseProgress(_mor, percent);
	}
	
	public ProgressReporter createProgressReporter() {
		return new ProgressReporter();
	}
	
	public static long calcTotalBytes(OvfCreateImportSpecResult ovfImportResult) {  
		OvfFileItem[] fileItemArr = ovfImportResult.getFileItem();  
		long totalBytes = 0;  
		if (fileItemArr != null) {  
			for (OvfFileItem fi : fileItemArr) {  
				totalBytes += fi.getSize();  
			}  
		}  
		return totalBytes;  
	}
	
	public static String readOvfContent(String ovfFilePath) throws IOException {  
		StringBuffer strContent = new StringBuffer();  
		BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream(ovfFilePath)));  
		String lineStr;  
		while ((lineStr = in.readLine()) != null) {  
			strContent.append(lineStr);  
		}  

		in.close();  
		return strContent.toString();  
	}
	
	public class ProgressReporter extends Thread {
		volatile int _percent;
		volatile boolean _done;
		
		public ProgressReporter() {
			_percent = 0;
			_done = false;
			
			setDaemon(true);
			start();
		}
		
		public void reportProgress(int percent) {
			_percent = percent;
		}
		
		public void close() {
			if(s_logger.isInfoEnabled())
				s_logger.info("close ProgressReporter, interrupt reporter runner to let it quit");
			
			_done = true;
			interrupt();
		}
		
		@Override
		public void run() {
			while(!_done) {
				try {
					Thread.sleep(1000);			// update progess every 1 second
					updateLeaseProgress(_percent);
				} catch(InterruptedException e) {
					if(s_logger.isInfoEnabled())
						s_logger.info("ProgressReporter is interrupted, quiting");
					break;
				} catch(Exception e) {
					s_logger.warn("Unexpected exception ", e);
				}
			}
			
			if(s_logger.isInfoEnabled())
				s_logger.info("ProgressReporter stopped");
		}
	}
}

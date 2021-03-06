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
package com.cloud.api.commands;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.cloud.api.ApiConstants;
import com.cloud.api.BaseAsyncCmd;
import com.cloud.api.BaseCmd;
import com.cloud.api.IdentityMapper;
import com.cloud.api.Implementation;
import com.cloud.api.Parameter;
import com.cloud.api.ServerApiException;
import com.cloud.api.BaseCmd.CommandType;
import com.cloud.api.response.UserVmResponse;
import com.cloud.api.response.ZoneResponse;
import com.cloud.async.AsyncJob;
import com.cloud.event.EventTypes;
import com.cloud.exception.InvalidParameterValueException;
import com.cloud.user.Account;
import com.cloud.uservm.UserVm;

@Implementation(description="Move a user VM to another user under same domain.", responseObject=UserVmResponse.class, since="3.0.0")
public class AssignVMCmd extends BaseCmd  {
    public static final Logger s_logger = Logger.getLogger(AssignVMCmd.class.getName());

    private static final String s_name = "moveuservmresponse";

    /////////////////////////////////////////////////////
    //////////////// API parameters /////////////////////
    /////////////////////////////////////////////////////
    
    @IdentityMapper(entityTableName="vm_instance")
    @Parameter(name=ApiConstants.VIRTUAL_MACHINE_ID, type=CommandType.LONG, required=true, description="the vm ID of the user VM to be moved")
    private Long virtualMachineId;
    
    @Parameter(name=ApiConstants.ACCOUNT, type=CommandType.STRING, required=true, description="account name of the new VM owner.")
    private String accountName;
    
    @IdentityMapper(entityTableName="domain")
    @Parameter(name=ApiConstants.DOMAIN_ID, type=CommandType.LONG, required=true, description="domain id of the new VM owner.")
    private Long domainId;

    //Network information
    @IdentityMapper(entityTableName="networks")
    @Parameter(name=ApiConstants.NETWORK_IDS, type=CommandType.LIST, collectionType=CommandType.LONG, description="list of network ids that will be part of VM network after move in advanced network setting.")
    private List<Long> networkIds;

    @IdentityMapper(entityTableName="security_group")
    @Parameter(name=ApiConstants.SECURITY_GROUP_IDS, type=CommandType.LIST, collectionType=CommandType.LONG, description="comma separated list of security groups id that going to be applied to the virtual machine. Should be passed only when vm is moved in a zone with Basic Network support.")
    private List<Long> securityGroupIdList;
    
    /////////////////////////////////////////////////////
    /////////////////// Accessors ///////////////////////
    /////////////////////////////////////////////////////

    public Long getVmId() {
        return virtualMachineId;
    }

    public String getAccountName() {
        return accountName;
    }

	public Long getDomainId() {
		return domainId;
	}
	
	public List<Long> getNetworkIds() {
		return networkIds;
	}

	public List<Long> getSecurityGroupIdList() {
		return securityGroupIdList;
	}


    /////////////////////////////////////////////////////
    /////////////// API Implementation///////////////////
    /////////////////////////////////////////////////////

    @Override
    public String getCommandName() {
        return s_name;
    }
    
    @Override
    public void execute(){
        try {
           UserVm userVm = _userVmService.moveVMToUser(this);
           if (userVm == null){
               throw new ServerApiException(BaseCmd.INTERNAL_ERROR, "Failed to move vm");
           }  
           UserVmResponse response = _responseGenerator.createUserVmResponse("virtualmachine", userVm).get(0);            
           response.setResponseName(DeployVMCmd.getResultObjectName());           
           this.setResponseObject(response);
        }catch (Exception e){
            e.printStackTrace();
            throw new ServerApiException(BaseCmd.INTERNAL_ERROR, "Failed to move vm " + e.getMessage());
        }
        
    }

    @Override
    public long getEntityOwnerId() {
        UserVm vm = _responseGenerator.findUserVmById(getVmId());
        if (vm != null) {
            return vm.getAccountId();
        }

        return Account.ACCOUNT_ID_SYSTEM; // no account info given, parent this command to SYSTEM so ERROR events are tracked
    }

}

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
package com.cloud.network.dao;

import java.util.List;

import javax.ejb.Local;

import org.apache.log4j.Logger;

import com.cloud.network.RemoteAccessVpn;
import com.cloud.network.RemoteAccessVpnVO;
import com.cloud.utils.db.GenericDaoBase;
import com.cloud.utils.db.SearchBuilder;
import com.cloud.utils.db.SearchCriteria;

@Local(value={RemoteAccessVpnDao.class})
public class RemoteAccessVpnDaoImpl extends GenericDaoBase<RemoteAccessVpnVO, Long> implements RemoteAccessVpnDao {
    private static final Logger s_logger = Logger.getLogger(RemoteAccessVpnDaoImpl.class);
    
    private final SearchBuilder<RemoteAccessVpnVO> AllFieldsSearch;


    protected RemoteAccessVpnDaoImpl() {
        AllFieldsSearch = createSearchBuilder();
        AllFieldsSearch.and("accountId", AllFieldsSearch.entity().getAccountId(), SearchCriteria.Op.EQ);
        AllFieldsSearch.and("networkId", AllFieldsSearch.entity().getNetworkId(), SearchCriteria.Op.EQ);
        AllFieldsSearch.and("ipAddress", AllFieldsSearch.entity().getServerAddressId(), SearchCriteria.Op.EQ);
        AllFieldsSearch.and("state", AllFieldsSearch.entity().getState(), SearchCriteria.Op.EQ);
        AllFieldsSearch.done();
    }

    @Override
    public RemoteAccessVpnVO findByPublicIpAddress(long ipAddressId) {
        SearchCriteria<RemoteAccessVpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("ipAddress", ipAddressId);
        return findOneBy(sc);
    }

    @Override
    public RemoteAccessVpnVO findByAccountAndNetwork(Long accountId, Long networkId) {
        SearchCriteria<RemoteAccessVpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("accountId", accountId);
        sc.setParameters("networkId", networkId);
        return findOneBy(sc);
    }

	@Override
	public List<RemoteAccessVpnVO> findByAccount(Long accountId) {
		SearchCriteria<RemoteAccessVpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("accountId", accountId);
        return listBy(sc);
	}
	
	@Override
	public RemoteAccessVpnVO findByPublicIpAddressAndState(long ipAddressId, RemoteAccessVpn.State state) {
	    SearchCriteria<RemoteAccessVpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("ipAddress", ipAddressId);
        sc.setParameters("state", state);
        return findOneBy(sc);
	}
	
	@Override
	public List<RemoteAccessVpnVO> listByNetworkId(Long networkId) {
	    SearchCriteria<RemoteAccessVpnVO> sc = AllFieldsSearch.create();
        sc.setParameters("networkId", networkId);
        return listBy(sc);
	}
}

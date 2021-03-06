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
package com.cloud.api.response;

import java.util.Date;

import com.cloud.api.ApiConstants;
import com.cloud.utils.IdentityProxy;
import com.cloud.host.Host;
import com.cloud.host.Status;
import com.cloud.hypervisor.Hypervisor.HypervisorType;
import com.cloud.serializer.Param;
import com.google.gson.annotations.SerializedName;

public class HostResponse extends BaseResponse {
    @SerializedName(ApiConstants.ID) @Param(description="the ID of the host")
    private IdentityProxy id = new IdentityProxy("host");

    @SerializedName(ApiConstants.NAME) @Param(description="the name of the host")
    private String name;

    @SerializedName(ApiConstants.STATE) @Param(description="the state of the host")
    private Status state;

    @SerializedName("disconnected") @Param(description="true if the host is disconnected. False otherwise.")
    private Date disconnectedOn;

    @SerializedName(ApiConstants.TYPE) @Param(description="the host type")
    private Host.Type hostType;

    @SerializedName("oscategoryid") @Param(description="the OS category ID of the host")
    private IdentityProxy osCategoryId = new IdentityProxy("guest_os_category");

    @SerializedName("oscategoryname") @Param(description="the OS category name of the host")
    private String osCategoryName;

    @SerializedName(ApiConstants.IP_ADDRESS) @Param(description="the IP address of the host")
    private String ipAddress;

    @SerializedName(ApiConstants.ZONE_ID) @Param(description="the Zone ID of the host")
    private IdentityProxy zoneId = new IdentityProxy("data_center");

    @SerializedName(ApiConstants.ZONE_NAME) @Param(description="the Zone name of the host")
    private String zoneName;

    @SerializedName(ApiConstants.POD_ID) @Param(description="the Pod ID of the host")
    private IdentityProxy podId = new IdentityProxy("host_pod_ref");

    @SerializedName("podname") @Param(description="the Pod name of the host")
    private String podName;

    @SerializedName("version") @Param(description="the host version")
    private String version;

    @SerializedName(ApiConstants.HYPERVISOR) @Param(description="the host hypervisor")
    private HypervisorType hypervisor;

    @SerializedName("cpunumber") @Param(description="the CPU number of the host")
    private Integer cpuNumber;

    @SerializedName("cpuspeed") @Param(description="the CPU speed of the host")
    private Long cpuSpeed;

    @SerializedName("cpuallocated") @Param(description="the amount of the host's CPU currently allocated")
    private String cpuAllocated;

    @SerializedName("cpuused") @Param(description="the amount of the host's CPU currently used")
    private String cpuUsed;

    @SerializedName("cpuwithoverprovisioning") @Param(description="the amount of the host's CPU after applying the cpu.overprovisioning.factor ")
    private String cpuWithOverprovisioning;

    @SerializedName("averageload") @Param(description="the cpu average load on the host")
    private Long averageLoad;

    @SerializedName("networkkbsread") @Param(description="the incoming network traffic on the host")
    private Long networkKbsRead;

    @SerializedName("networkkbswrite") @Param(description="the outgoing network traffic on the host")
    private Long networkKbsWrite;

    @SerializedName("memorytotal") @Param(description="the memory total of the host")
    private Long memoryTotal;

    @SerializedName("memoryallocated") @Param(description="the amount of the host's memory currently allocated")
    private Long memoryAllocated;

    @SerializedName("memoryused") @Param(description="the amount of the host's memory currently used")
    private Long memoryUsed;

    @SerializedName("disksizetotal") @Param(description="the total disk size of the host")
    private Long diskSizeTotal;

    @SerializedName("disksizeallocated") @Param(description="the host's currently allocated disk size")
    private Long diskSizeAllocated;

    @SerializedName("capabilities") @Param(description="capabilities of the host")
    private String capabilities;

    @SerializedName("lastpinged") @Param(description="the date and time the host was last pinged")
    private Date lastPinged;

    @SerializedName("managementserverid") @Param(description="the management server ID of the host")
    private Long managementServerId;

    @SerializedName("clusterid") @Param(description="the cluster ID of the host")
    private IdentityProxy clusterId = new IdentityProxy("cluster");

    @SerializedName("clustername") @Param(description="the cluster name of the host")
    private String clusterName;

    @SerializedName("clustertype") @Param(description="the cluster type of the cluster that host belongs to")
    private String clusterType;

    @SerializedName("islocalstorageactive") @Param(description="true if local storage is active, false otherwise")
    private Boolean localStorageActive;

    @SerializedName(ApiConstants.CREATED) @Param(description="the date and time the host was created")
    private Date created;

    @SerializedName("removed") @Param(description="the date and time the host was removed")
    private Date removed;

    @SerializedName("events") @Param(description="events available for the host")
    private String events;

    @SerializedName("hosttags") @Param(description="comma-separated list of tags for the host")
    private String hostTags;

    @SerializedName("hasenoughcapacity") @Param(description="true if this host has enough CPU and RAM capacity to migrate a VM to it, false otherwise")
    private Boolean hasEnoughCapacity;

    @SerializedName("suitableformigration") @Param(description="true if this host is suitable(has enough capacity and satisfies all conditions like hosttags, max guests vm limit etc) to migrate a VM to it , false otherwise")
    private Boolean suitableForMigration;

    @SerializedName("resourcestate") @Param(description="the resource state of the host")
    private String resourceState;

    @SerializedName(ApiConstants.HYPERVISOR_VERSION) @Param(description="the hypervisor version")
    private String hypervisorVersion;


    @Override
    public Long getObjectId() {
        return getId();
    }
    
    public Long getId() {
        return id.getValue();
    }

    public void setId(Long id) {
        this.id.setValue(id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Status getState() {
        return state;
    }

    public void setState(Status state) {
        this.state = state;
    }

    public Date getDisconnectedOn() {
        return disconnectedOn;
    }

    public void setDisconnectedOn(Date disconnectedOn) {
        this.disconnectedOn = disconnectedOn;
    }

    public Host.Type getHostType() {
        return hostType;
    }

    public void setHostType(Host.Type hostType) {
        this.hostType = hostType;
    }

    public Long getOsCategoryId() {
        return osCategoryId.getValue();
    }

    public void setOsCategoryId(Long osCategoryId) {
        this.osCategoryId.setValue(osCategoryId);
    }

    public String getOsCategoryName() {
        return osCategoryName;
    }

    public void setOsCategoryName(String osCategoryName) {
        this.osCategoryName = osCategoryName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public Long getZoneId() {
        return zoneId.getValue();
    }

    public void setZoneId(Long zoneId) {
        this.zoneId.setValue(zoneId);
    }

    public String getZoneName() {
        return zoneName;
    }

    public void setZoneName(String zoneName) {
        this.zoneName = zoneName;
    }

    public Long getPodId() {
        return podId.getValue();
    }

    public void setPodId(Long podId) {
        this.podId.setValue(podId);
    }

    public String getPodName() {
        return podName;
    }

    public void setPodName(String podName) {
        this.podName = podName;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public HypervisorType getHypervisor() {
        return hypervisor;
    }

    public void setHypervisor(HypervisorType hypervisor) {
        this.hypervisor = hypervisor;
    }

    public Integer getCpuNumber() {
        return cpuNumber;
    }

    public void setCpuNumber(Integer cpuNumber) {
        this.cpuNumber = cpuNumber;
    }

    public Long getCpuSpeed() {
        return cpuSpeed;
    }

    public void setCpuSpeed(Long cpuSpeed) {
        this.cpuSpeed = cpuSpeed;
    }

    public String getCpuAllocated() {
        return cpuAllocated;
    }

    public void setCpuAllocated(String cpuAllocated) {
        this.cpuAllocated = cpuAllocated;
    }

    public String getCpuUsed() {
        return cpuUsed;
    }

    public void setCpuUsed(String cpuUsed) {
        this.cpuUsed = cpuUsed;
    }

    public Long getAverageLoad() {
        return averageLoad;
    }

    public void setAverageLoad(Long averageLoad) {
        this.averageLoad = averageLoad;
    }

    public Long getNetworkKbsRead() {
        return networkKbsRead;
    }

    public void setNetworkKbsRead(Long networkKbsRead) {
        this.networkKbsRead = networkKbsRead;
    }

    public Long getNetworkKbsWrite() {
        return networkKbsWrite;
    }

    public void setNetworkKbsWrite(Long networkKbsWrite) {
        this.networkKbsWrite = networkKbsWrite;
    }

    public Long getMemoryTotal() {
        return memoryTotal;
    }

    public void setMemoryTotal(Long memoryTotal) {
        this.memoryTotal = memoryTotal;
    }

    public Long getMemoryAllocated() {
        return memoryAllocated;
    }

    public void setMemoryAllocated(Long memoryAllocated) {
        this.memoryAllocated = memoryAllocated;
    }

    public Long getMemoryUsed() {
        return memoryUsed;
    }

    public void setMemoryUsed(Long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public Long getDiskSizeTotal() {
        return diskSizeTotal;
    }

    public void setDiskSizeTotal(Long diskSizeTotal) {
        this.diskSizeTotal = diskSizeTotal;
    }

    public Long getDiskSizeAllocated() {
        return diskSizeAllocated;
    }

    public void setDiskSizeAllocated(Long diskSizeAllocated) {
        this.diskSizeAllocated = diskSizeAllocated;
    }

    public String getCapabilities() {
        return capabilities;
    }

    public void setCapabilities(String capabilities) {
        this.capabilities = capabilities;
    }

    public Date getLastPinged() {
        return lastPinged;
    }

    public void setLastPinged(Date lastPinged) {
        this.lastPinged = lastPinged;
    }

    public Long getManagementServerId() {
        return managementServerId;
    }

    public void setManagementServerId(Long managementServerId) {
        this.managementServerId = managementServerId;
    }

    public Long getClusterId() {
        return clusterId.getValue();
    }

    public void setClusterId(Long clusterId) {
        this.clusterId.setValue(clusterId);
    }

    public String getClusterName() {
        return clusterName;
    }

    public void setClusterName(String clusterName) {
        this.clusterName = clusterName;
    }

    public String getClusterType() {
        return clusterType;
    }

    public void setClusterType(String clusterType) {
        this.clusterType = clusterType;
    }

    public Boolean isLocalStorageActive() {
        return localStorageActive;
    }

    public void setLocalStorageActive(Boolean localStorageActive) {
        this.localStorageActive = localStorageActive;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getRemoved() {
        return removed;
    }

    public void setRemoved(Date removed) {
        this.removed = removed;
    }

    public String getEvents() {
        return events;
    }

    public void setEvents(String events) {
        this.events = events;
    }

    public String getHostTags() {
        return hostTags;
    }

    public void setHostTags(String hostTags) {
        this.hostTags = hostTags;
    }

    public Boolean hasEnoughCapacity() {
        return hasEnoughCapacity;
    }

    public void setHasEnoughCapacity(Boolean hasEnoughCapacity) {
        this.hasEnoughCapacity = hasEnoughCapacity;
    }
    
    public Boolean isSuitableForMigration() {
        return suitableForMigration;
    }

    public void setSuitableForMigration(Boolean suitableForMigration) {
        this.suitableForMigration = suitableForMigration;
    }    

    public String getResourceState() {
        return resourceState;
    }

    public void setResourceState(String resourceState) {
        this.resourceState = resourceState;
    }

    public String getCpuWithOverprovisioning() {
        return cpuWithOverprovisioning;
    }

    public void setCpuWithOverprovisioning(String cpuWithOverprovisioning) {
        this.cpuWithOverprovisioning = cpuWithOverprovisioning;
    }

    public void setHypervisorVersion(String hypervisorVersion) {
        this.hypervisorVersion = hypervisorVersion;
    }

    public String getHypervisorVersion() {
        return hypervisorVersion;
    }   

}

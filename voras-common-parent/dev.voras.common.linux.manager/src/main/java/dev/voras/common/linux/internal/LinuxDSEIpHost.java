package dev.voras.common.linux.internal;

import dev.voras.common.ipnetwork.IIpPort;
import dev.voras.common.ipnetwork.IpNetworkManagerException;
import dev.voras.common.ipnetwork.spi.AbstractGenericIpHost;
import dev.voras.framework.spi.creds.CredentialsException;

public class LinuxDSEIpHost extends AbstractGenericIpHost {
	
	protected LinuxDSEIpHost(LinuxManagerImpl linuxManager, String hostid) throws IpNetworkManagerException, CredentialsException {
		super(linuxManager.getCps(), linuxManager.getDss(), linuxManager.getFramework().getCredentialsService(), "image", hostid);
	}

	@Override
	public IIpPort provisionPort(String type) throws IpNetworkManagerException {
		throw new UnsupportedOperationException("Not written yet");
	}

}

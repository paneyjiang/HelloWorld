package com.sitech.rmi.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

public class TestRmi {
	
	public static void main(String[] args) {
		 String  rmiUrl="rmi://127.0.0.1:1099/seq";
		 rmiRemotImpl remoteSeqService;
		try {
			  remoteSeqService = new rmiRemotImpl();
			  LocateRegistry.createRegistry(Integer.parseInt("1099"));
		      try {
				Naming.rebind(rmiUrl, remoteSeqService);
			} catch (MalformedURLException e) {
				e.printStackTrace();
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	     
	}

}

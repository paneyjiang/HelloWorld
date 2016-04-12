package com.sitech.rmi.service;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class TestRMIClient {
	public static void main(String[] args) throws MalformedURLException, RemoteException, NotBoundException {
		
		//调用方
		rmiRemot remoteSeqService = (rmiRemot) Naming.lookup("rmi://localhost:1099/seq");
		remoteSeqService.sayHello();
		
	}

}

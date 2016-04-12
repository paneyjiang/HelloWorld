package com.sitech.rmi.service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class rmiRemotImpl  extends UnicastRemoteObject implements rmiRemot {

	public  rmiRemotImpl() throws RemoteException {
		super();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void sayHello() {
 
		
		System.out.println("hello");
	}

}

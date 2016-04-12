package com.sitech.rmi.service;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface rmiRemot extends Remote {

	
	public abstract void sayHello()  throws RemoteException;
}

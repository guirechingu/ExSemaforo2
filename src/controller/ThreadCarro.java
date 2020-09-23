package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread {
	private int id;
	private String sentido;
	private Semaphore semaforoSentido;
	
	public ThreadCarro(int id , String dir , Semaphore semaforo) {
		this.id=id;
		this.sentido=dir;
		this.semaforoSentido = semaforo;
	}
	
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		try {
			semaforoSentido.acquire();
			cruzarSemaforo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}finally {
			semaforoSentido.release();
		}
	}

	private void cruzarSemaforo() {
		System.out.println("O Carro : "+this.id+" Passou o Semaforo indo : "+this.sentido);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}

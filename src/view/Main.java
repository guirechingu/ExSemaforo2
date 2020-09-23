package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Main {

	public static void main(String[] args) {
		Semaphore sm = new Semaphore(1);
		String dir[] = {"Norte","Leste","Sul","Oeste"};
		ThreadCarro [] tc = new ThreadCarro[4];
		
		for (int i = 0; i < tc.length; i++) {
			tc[i] = new ThreadCarro(i, dir[(i%dir.length)],sm);
		}
		  for (int i = 0; i < tc.length; i++) { tc[i].start();}

	}

}

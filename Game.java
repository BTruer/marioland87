import java.awt.*;
//import Animation.java.*;
//public boolean running = false;
public class Game{
	public static void main(String[] args) throws InterruptedException{
		//framework
		Animation game = new Animation(600,400);
		game.setBackgroundImage("bk.png");
		//framrate
		game.setFrameRate(50);
//Thread.sleep(500);
		//sprites
		Sprite back = new Sprite("Stage.png");
		game.addSprite(back);
		Sprite man = new Sprite("mar1.png");
		int x=man.getXsize();
		int y=man.getYsize();
		man.setSize((int)	x*2, (int)y*2);
		game.addSprite(man);
		man.setPosition(300-x,45);
		game.frameFinished();
		Sprite mega = new Sprite("mega.png");
		mega.setPosition(600,45);

	System.out.println("Welcome to 'marioland87'. Your goal is to get to the end and meet the princess");
		//game running
		//6212 is total length
		for(int i =0;i<100;i++){
			back.setPosition((back.getXposition()-1),back.getYposition());
			//animation for running
			if(i%2 == 0){
				man.setImage("mar1.png");
			}else{man.setImage("mar2.png");}
			man.setPosition(300-x,45);
			game.frameFinished();
		}
		game.addSprite(mega);
		int mov =0;

		for(int i =0;i< 200;i++){
			back.setPosition((back.getXposition()-1),back.getYposition());
			//animation for running
			if(i%2 == 0){
				man.setImage("mar1.png");
			}else{man.setImage("mar2.png");}
			man.setPosition(300-x,45);
			mega.setPosition(600-mov,45);
			mov++;
			game.frameFinished();
		}
		man.setImage("mar1.png");
		game.frameFinished();
		System.out.println("Do you wish to jump or attack?(input:attack or jump)");
		String answer = IO.readString();
		

		if(answer.equals("attack")){
			man.setImage("mar3.png");
			game.frameFinished();
			Thread.sleep(100);
			man.setImage("mar4.png");
			Sprite item = new Sprite("item.png");
			item.setPosition(300-x+10,45+50);
			item.setSize((item.getXsize()*2),(item.getYsize()*2));
			game.addSprite(item);
			game.frameFinished();
			Thread.sleep(100);
			man.setImage("mar5.png");
			for(int i=item.getXposition();i<mega.getXposition();i++){
				item.setPosition(i+4,item.getYposition());
				game.frameFinished();
			}
			game.removeSprite(item);
			for(int i=mega.getYposition();i>back.getYposition();i--){
				mega.setPosition(mega.getXposition(),mega.getYposition()-1);
				game.frameFinished();	
			}
			game.removeSprite(mega);
			game.frameFinished();
			 


			for(int i=0;i<50;i++){
				back.setPosition((back.getXposition()-1),back.getYposition());
				//animation for running
				if(i%2 == 0){
				man.setImage("mar1.png");
				}else{man.setImage("mar2.png");}
				man.setPosition(300-x,45);
			game.frameFinished();		
			}
			//part 2
			Sprite block = new Sprite("blockSp.png");
			Sprite megaB = new Sprite("megablock.png");
			block.setPosition(600,150);
			megaB.setPosition(600,45);
			game.addSprite(block);
			game.addSprite(megaB);
			for(int i=0;i<500;i++){
				back.setPosition((back.getXposition()-1),back.getYposition());
				if(i%2 == 0){
				man.setImage("mar1.png");
				}else{man.setImage("mar2.png");}
				block.setPosition(block.getXposition()-1,block.getYposition());
				game.frameFinished();
				if(block.getXposition()<man.getXposition()+10){
					break;
				}

			}
			System.out.println("jump or go forward (INPUT:jump or forward)");
			String st= IO.readString();
			while(!(st.equals("jump") || st.equals("forward"))){
				System.out.println("jump or go forward (INPUT:jump or forward)");
				System.out.println("need to give good input for this one");
				st=IO.readString();
			}
			if(st.equals("jump")){
				man.setImage("mar2.png");
				for(int i=(block.getYposition())-(man.getYposition());i>10;i--){
					man.setPosition(man.getXposition(),man.getYposition()+1);
					game.frameFinished();
				}
				man.setImage("pl1.png");
				game.frameFinished();
				for(int i=man.getYposition();i>45;i--){
					man.setPosition(man.getXposition(),man.getYposition()-1);
					back.setPosition((back.getXposition()-1),back.getYposition());
					if(i%2 == 0){
					man.setImage("pl1.png");
					}else{man.setImage("pl2.png");}
					block.setPosition(block.getXposition()-1,block.getYposition());
					megaB.setPosition(megaB.getXposition()-1,megaB.getYposition());
					game.frameFinished();	

				}
				game.setFrameRate(120);
				for(int i=0;i<900;i++){
					if(i%2 == 0){
					man.setImage("pl1.png");
					}else{man.setImage("pl2.png");}
					game.frameFinished();
					if(megaB.getXposition()<man.getXposition()){megaB.setImage("megablock12.png");
						megaB.setPosition(megaB.getXposition(),megaB.getYposition()-1);}
					man.setPosition(man.getXposition(),man.getYposition());
					back.setPosition((back.getXposition()-1),back.getYposition());
					block.setPosition(block.getXposition()-1,block.getYposition());
					megaB.setPosition(megaB.getXposition()-1,megaB.getYposition());	
				}
				game.removeSprite(block);
				game.removeSprite(megaB);
				//end game win
				Sprite p = new Sprite("peach.png");
				p.setPosition(600,45);
				game.addSprite(p);
				p.setSize((p.getXsize())*2,(p.getYsize())*2);
				for(int i=0;i<80;i++){
					if(i%2 == 0){
					man.setImage("mar1.png");
					}else{man.setImage("mar2.png");}
					back.setPosition((back.getXposition()-1),back.getYposition());
					p.setPosition(p.getXposition()-1,p.getYposition());
					game.frameFinished();
				}
				System.out.println("Congrats YOU WON!");


			}


			if(st.equals("forward")){
				for(int i=0;i<200;i++){
				back.setPosition((back.getXposition()-1),back.getYposition());
				if(i%2 == 0){
				man.setImage("mar1.png");
				}else{man.setImage("mar2.png");}
				block.setPosition(block.getXposition()-1,block.getYposition());
				megaB.setPosition(megaB.getXposition()-1,megaB.getYposition());
				game.frameFinished();
				}
				man.setImage("mar7.png");
				game.frameFinished();
				System.out.println("TOO MANY megamans");
				System.out.println("GAMEOVER");
				return;
			}


		}
		

		else if(answer.equals("jump")){
			man.setImage("mar6.png");
			//moving up
			for(int i=0;i<70;i++){
				man.setPosition(man.getXposition(),man.getYposition()+1);
				game.frameFinished();					
			}
			//moving right and down
			for(int i=0;i<500;i++){
				mega.setPosition((mega.getXposition()-1),mega.getYposition());
				back.setPosition((back.getXposition()-1),back.getYposition());
				if(man.getXposition()>mega.getXposition()){
					mega.setImage("mega2.png");
				}
				if(man.getXposition()-50>mega.getXposition() && man.getYposition()>=45){
						man.setPosition(man.getXposition(),man.getYposition()-1);

				}
				if(man.getYposition()==45){ break;}
				game.frameFinished();	
			}
			Sprite block = new Sprite("blockSp.png");
			Sprite megaB = new Sprite("megablock.png");
			block.setPosition(600,150);
			megaB.setPosition(600,45);
			game.addSprite(block);
			game.addSprite(megaB);
			for(int i=0;i<500;i++){
				back.setPosition((back.getXposition()-1),back.getYposition());
				if(i%2 == 0){
				man.setImage("mar1.png");
				}else{man.setImage("mar2.png");}
				block.setPosition(block.getXposition()-1,block.getYposition());
				game.frameFinished();
				mega.setPosition((mega.getXposition()-1),mega.getYposition());
				if(block.getXposition()<man.getXposition()+10){
					break;
				}

			}
			System.out.println("jump or go forward (INPUT:jump or forward)");
			String st= IO.readString();
			while(!(st.equals("jump") || st.equals("forward"))){
				System.out.println("jump or go forward (INPUT:jump or forward)");
				System.out.println("need to give good input for this one");
				st=IO.readString();
			}
			if(st.equals("jump")){
				man.setImage("mar2.png");
				for(int i=(block.getYposition())-(man.getYposition());i>10;i--){
					man.setPosition(man.getXposition(),man.getYposition()+1);
					game.frameFinished();
				}
				man.setImage("pl1.png");
				game.frameFinished();
				for(int i=man.getYposition();i>45;i--){
					man.setPosition(man.getXposition(),man.getYposition()-1);
					back.setPosition((back.getXposition()-1),back.getYposition());
					if(i%2 == 0){
					man.setImage("pl1.png");
					}else{man.setImage("pl2.png");}
					block.setPosition(block.getXposition()-1,block.getYposition());
					megaB.setPosition(megaB.getXposition()-1,megaB.getYposition());
					game.frameFinished();	

				}
				game.setFrameRate(120);
				for(int i=0;i<900;i++){
					if(i%2 == 0){
					man.setImage("pl1.png");
					}else{man.setImage("pl2.png");}
					game.frameFinished();
					if(megaB.getXposition()<man.getXposition()){megaB.setImage("megablock12.png");
						megaB.setPosition(megaB.getXposition(),megaB.getYposition()-1);}
					man.setPosition(man.getXposition(),man.getYposition());
					back.setPosition((back.getXposition()-1),back.getYposition());
					block.setPosition(block.getXposition()-1,block.getYposition());
					megaB.setPosition(megaB.getXposition()-1,megaB.getYposition());	
				}
				game.removeSprite(block);
				game.removeSprite(megaB);
				//end game win
				Sprite p = new Sprite("peach.png");
				p.setPosition(600,45);
				game.addSprite(p);
				p.setSize((p.getXsize())*2,(p.getYsize())*2);
				for(int i=0;i<80;i++){
					if(i%2 == 0){
					man.setImage("mar1.png");
					}else{man.setImage("mar2.png");}
					back.setPosition((back.getXposition()-1),back.getYposition());
					p.setPosition(p.getXposition()-1,p.getYposition());
					game.frameFinished();
				}
				System.out.println("Congrats YOU WON!");


			}


			if(st.equals("forward")){
				for(int i=0;i<200;i++){
				back.setPosition((back.getXposition()-1),back.getYposition());
				if(i%2 == 0){
				man.setImage("mar1.png");
				}else{man.setImage("mar2.png");}
				block.setPosition(block.getXposition()-1,block.getYposition());
				megaB.setPosition(megaB.getXposition()-1,megaB.getYposition());
				game.frameFinished();
				}
				man.setImage("mar7.png");
				game.frameFinished();
				System.out.println("TOO MANY megamans");
				System.out.println("GAMEOVER");
				return;
			}


		}else{
			System.out.println("uh oh thats not a good command! Watch out!!!");
			for(int i=mega.getXposition();i>man.getXposition();i--){
				mega.setPosition(mega.getXposition()-1,man.getYposition());
				game.frameFinished();
			}
			mega.setImage("mega4.png");
				game.frameFinished();
			System.out.println("MEGAMAN GOT YOU!!!");
			System.out.println("MEGAMAN GOT YOU!!!");
			System.out.println("MEGAMAN GOT YOU!!!");
			System.out.println("MEGAMAN GOT YOU!!!");
			System.out.println("GAMEOVER");
			System.out.println("GAMEOVER");
			System.out.println("GAMEOVER");
			System.out.println("GAMEOVER");
			System.out.println("GAMEOVER");
			System.out.println("GAMEOVER");
			System.out.println("PLEASE CLOSE AND TRY AGAIN!(YOU CAN DO IT!)");
			//Thread.sleep(10000);
			return;
		}
			
	



	}
	
}
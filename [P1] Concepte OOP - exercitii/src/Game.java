
public class Game {

	public static void main(String[] args) {
		PlayerStatus p1 = new PlayerStatus();
		PlayerStatus p2 = new PlayerStatus();

		p1.initPlayer("player1", 3, 30000);
		p1.setHealth(100);
		p1.setWeaponInHand("kalashnikov");
		p1.movePlayerTo(589.258, 126.358);
		p1.setGameName("Joc Test");

		System.out.println(p1.getNickname() + " " + p1.getScore() + " " + p1.getLives() + " " + p1.getHealth() + " "
				+ p1.getPositionX() + " " + p1.getPositionY());

		p1.findArtifact(18);
		p1.findArtifact(18);
		p1.findArtifact(18);
		p1.findArtifact(18);
		System.out.println(p1.getScore() + " " + p1.getLives() + " " + p1.getHealth());
		
		p1.findArtifact(6);
		System.out.println(p1.getScore() + " " + p1.getLives() + " " + p1.getHealth());
		
		p1.findArtifact(3);
		System.out.println(p1.getScore() + " " + p1.getLives() + " " + p1.getHealth());
		
		p1.findArtifact(8);
		System.out.println(p1.getScore() + " " + p1.getLives() + " " + p1.getHealth());
		
		
		p2.initPlayer("player1", 3, 30000);
		p2.setHealth(100);
		p2.setWeaponInHand("sniper");
		p2.movePlayerTo(1000, 1215);
		
		
		boolean a=p1.shouldAttackOponent(p2);
		boolean b=p2.shouldAttackOponent(p1);
		System.out.println(a +" "+b);
		
	}

}

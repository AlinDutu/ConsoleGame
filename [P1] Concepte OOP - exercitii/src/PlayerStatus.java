
public class PlayerStatus {

	private String nickname;
	private int score;
	private int lives;
	private int health;
	private String weaponInHand;
	private double positionX;
	private double positionY;
	private ArtifactType artifact;
	static String gameName;

	// getter & setter pentru nickname
	public String getNickname() {
		return nickname;
	}

	// getter & setter pentru score
	public int getScore() {
		return score;
	}

	 void setScore(int score) {
		this.score = this.score + score;

		if (this.score < 0) {
			this.score = 0;
		}
	}

	// getter & setter pentru lives
	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = this.lives + lives;

		if (this.lives <= 0) {
			System.out.println("Game Over!");
		}
	}

	// getter & setter pentru health

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = this.health + health;

		if (this.health <= 0) {
			this.health = 100;
			setLives(-1);
		}

		if (this.health > 100) {
			this.health = 100;
		}
	}

	// getter & setter pentru weaponInHand
	public String getWeaponInHand() {
		return weaponInHand;
	}

	// metoda care seteaza arma jucatorului
	public boolean setWeaponInHand(String weaponInHand) {

		if (weaponInHand.equals("kalashnikov") && this.score >= 20000) {
			setScore(-20000);
			this.weaponInHand = weaponInHand;
			return true;
		} else if (weaponInHand.equals("sniper") && this.score >= 10000) {
			setScore(-10000);
			this.weaponInHand = weaponInHand;
			return true;
		} else if (weaponInHand.equals("knife") && this.score >= 1000) {
			setScore(-1000);
			this.weaponInHand = weaponInHand;
			return true;
		}
		return false;
	}

	// getter & setter pentru positionY
	public double getPositionY() {
		return positionY;
	}

	public void setPositionY(double positionY) {
		this.positionY = positionY;
	}

	// getter & setter pentru health positionX
	public double getPositionX() {
		return positionX;
	}

	public void setPositionX(double positionX) {
		this.positionX = positionX;
	}

	// getter & setter pentru gameName
	String getGameName() {
		return gameName;
	}

	void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public void setArtifact(ArtifactType artifact) {
		this.artifact = artifact;
	}

	// metode de initializare
	public void initPlayer(String nickname) {
		this.nickname = nickname;
	}

	public void initPlayer(String nickname, int lives) {
		this.nickname = nickname;
		this.lives = lives;
	}

	public void initPlayer(String nickname, int lives, int score) {
		this.nickname = nickname;
		this.lives = lives;
		this.score = score;
	}

	// metoda va actualiza starea jucatorului in functie de artifactul gasit
	void findArtifact(int artifactCode) {

		if (ArtifactType.perfect(artifactCode)) {
			setScore(5000);
			setLives(1);
			setHealth(100);
		} else if (ArtifactType.numarPrim(artifactCode)) {
			setScore(1000);
			setLives(2);
			setHealth(25);
		} else if (ArtifactType.numarParSumaDivizibilaCu3(artifactCode)) {
			setScore(-3000);
			setHealth(-25);
		} else {
			setScore(artifactCode);
		}

	}

	// metoda ce seteaza coordonatele unui jucator pe harta
	public void movePlayerTo(double positionX, double positionY) {
		this.positionX = positionX;
		this.positionY = positionY;
	}

	// metoda ce calculeaza distanta dintre 2 jucatori
	private double distantaDintreJucatori(double positionX2, double positionY2) {
		double distanta = Math
				.sqrt(Math.pow(this.positionX - positionX2, 2) + Math.pow(this.positionY - positionY2, 2));
		return distanta;
	}

	// metoda care decide daca este ok sau nu ca sa ataci un oponent
	boolean shouldAttackOponent(PlayerStatus oponent) {
		
		if (this.weaponInHand.equals(oponent.getWeaponInHand())) {
			if (((3 * this.health + this.score / 1000)
					/ 4 )> ((3 * oponent.getHealth() + oponent.getScore() / 1000) / 4)) {
				return true;
			} else
				return false;
		} 

		if (distantaDintreJucatori(oponent.positionX, oponent.positionY) > 1000) {
			if (getWeaponInHand().equals("sniper")) {
				return true;
			} else if (getWeaponInHand().equals("kalashnikov") && oponent.getWeaponInHand().equals("knife")) {
				return true;
			} else
				return false;
		}

		if (distantaDintreJucatori(oponent.positionX, oponent.positionY) < 1000) {
			if (getWeaponInHand().equals("kalashnikov")) {
				return true;
			} else if (getWeaponInHand().equals("sniper") && oponent.getWeaponInHand().equals("knife")) {
				return true;
			} else
				return false;
		}

		
		return false;

	}
	
	public void resetScore(int score) {
		if(score>0)
		this.score=score;
	}
	public void resetLives(int lives) {
		if(lives>0)
		this.lives=lives; 
	}
	public void resetHealth(int health) {
		if(health>0)
		this.health=health; 
	}

}

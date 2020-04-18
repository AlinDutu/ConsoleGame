
public class ArtifactType {

		//Numar Prim
		static boolean numarPrim(int artifactCode) {
			boolean prim = true;
			for (int i = 2; i <= artifactCode / 2; i++) {
				if (artifactCode % i == 0) {
					prim = false;
				}
			}
			return prim;
		}
		
		// Numar Perfect
		 static int divizor(int artifactCode, int i) {
			int div = 0;
			if (artifactCode % i == 0) {
				div = i;
			}
			return div;
		}

		static int sumaDiv(int artifactCode) {
			int suma = 0;
			for (int i = 1; i < artifactCode; i++) {
				suma = suma + divizor(artifactCode, i);
			}
			return suma;
		}

		static boolean perfect(int artifactCode) {
			boolean numarPerfect = false;
			if (sumaDiv(artifactCode) == artifactCode) {
				numarPerfect = true;
			}
			return numarPerfect;
		}
		
		// Numar par si suma cifrelor divizibila cu 3
		
		
		static boolean numarParSumaDivizibilaCu3 (int artifactCode) {
			boolean check=false;
			int sum=0;
			while (artifactCode>0) {
				int x=artifactCode%10;
				sum=sum+x;
				artifactCode=artifactCode/10;
			}
			
			if (artifactCode%2==0 & sum%3==0) {
				check=true;
			}
			return check;
			
		}
	}



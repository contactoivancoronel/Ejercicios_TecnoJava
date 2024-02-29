package models;

public abstract class Animal  implements Comparable<Animal> {

	private int cantOjos;

	public int getCantOjos() {
		return cantOjos;
	}

	public void setCantOjos(int cantOjos) {
		this.cantOjos = cantOjos;
	}
	
	public abstract void hacerRuido() ;
	public int compareTo(Animal otroAnimal) {
		
		//2 - 1 = 1
		// 3 - 7 = -4
		// 3 - 3 = 0
		return this.getCantOjos() - otroAnimal.getCantOjos();
	}
	
}

package models;

public abstract  class FiguraGeometrica 
implements Comparable<FiguraGeometrica>{
	
	public abstract double getArea() ;
	
	

	@Override
	public int compareTo(FiguraGeometrica otraFigura) {
		return (int) ((int) this.getArea() - otraFigura.getArea());
	}

}

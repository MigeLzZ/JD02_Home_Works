package by.htp.carparking.domain;

import java.io.Serializable;
import java.util.List;

public class Entity implements Serializable{  // был класс абстрактным

	private static final long serialVersionUID = -3204683336488394790L;
	
	private int id;
	private List<Car> cars;
	
	public Entity() {
		super();
	}

	public Entity(int id, List<Car> cars) {
		super();
		this.id = id;
		this.cars = cars;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<Car> getCars() {
		return cars;
	}

	public void setCars(List<Car> cars) {
		this.cars = cars;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cars == null) ? 0 : cars.hashCode());
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Entity other = (Entity) obj;
		if (cars == null) {
			if (other.cars != null)
				return false;
		} else if (!cars.equals(other.cars))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Entity [id=" + id + ", cars=" + cars + "]";
	}
	
}

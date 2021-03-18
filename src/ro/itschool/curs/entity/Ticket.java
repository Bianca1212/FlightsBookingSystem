package ro.itschool.curs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private int price;

	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "flight_id")
	private Flight flight;

	public Ticket(int id, int price, Flight flight) {
		super();
		this.id = id;
		this.price = price;
		this.flight = flight;
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", price=" + price + ", flight=" + flight + "]";
	}

}

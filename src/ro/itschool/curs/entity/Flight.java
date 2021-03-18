package ro.itschool.curs.entity;

import java.util.Map;
import java.util.TreeMap;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToOne;
import javax.persistence.JoinColumn;
import javax.persistence.MapKey;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor

public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private int id;

	@Column
	private String departurePlace;;

	@Column
	private String destination;

	@Column
	private String date;

	@ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "flight_seats_treemap", 
      joinColumns = {@JoinColumn(name = "flight_id", referencedColumnName = "id")})
	@MapKeyColumn(name = "seat_name") // column name for map "key"
	@Column(name = "seat_available") // column name for map "value"
	private Map<String, Boolean> seats = new TreeMap<String, Boolean>();

	@Column
	private String departureTime;

	@Column
	private String arrivalTime;

	@OneToOne(mappedBy = "flight")
	private Ticket ticket;

	public Flight(int id, String departurePlace, String destination, String date, Map<String, Boolean> seats,
			String departureTime, String arrivalTime) {
		super();
		this.id = id;
		this.departurePlace = departurePlace;
		this.destination = destination;
		this.date = date;
		this.seats = seats;
		this.departureTime = departureTime;
		this.arrivalTime = arrivalTime;
	}

	@Override
	public String toString() {
		return "\n Flight [id=" + id + ", departurePlace=" + departurePlace + ", destination=" + destination + ", date="
				+ date + ", seats=" + seats + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime
				+ "] \n";
	}

}

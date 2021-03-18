package ro.itschool.curs.entity;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ro.itschool.curs.enums.CustomerCategory;

@Entity
@Setter
@Getter
@NoArgsConstructor
@DiscriminatorValue("Customer")
public class Customer extends Passenger {

	@Enumerated(EnumType.STRING)
	@Column(name = "customer_category")
	private CustomerCategory customerCategory;

}

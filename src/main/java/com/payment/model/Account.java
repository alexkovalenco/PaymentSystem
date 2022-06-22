package com.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "ACCOUNT")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account {

	@Id
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

	@Column(name = "ACCOUNT_NUM")
	private String accountNum;

	@Column(name = "ACCOUNT_TYPE")
	private String accountType;

	@Column(name = "BALANCE")
	private Double balance;

//	@ManyToOne
//	@JoinColumn(name = "CLIENT_ID")
	@Column(name = "CLIENT_ID")
	private BigInteger clientId;


}

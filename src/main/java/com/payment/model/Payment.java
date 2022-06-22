package com.payment.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "PAYMENT")
@Data
@AllArgsConstructor
@Builder
public class Payment {

	@Id
	@Column(name = "ID", nullable = false, columnDefinition = "BIGINT")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private BigInteger id;

/*	@JoinColumn(name = "SOURCE_ACC_ID")
	@ManyToOne
	private Account sourceAccount;

	@JoinColumn(name = "DEST_ACC_ID")
	@ManyToOne
	private Account destAccount;*/

	@Column(name = "SOURCE_ACC_ID")
	private BigInteger sourceAccId;

	@Column(name = "DEST_ACC_ID")
	private BigInteger destAccId;

	@Column(name = "AMOUNT")
	private Double amount;

	@Column(name = "REASON")
	private String reason;

	@Column(name = "PAYMENT_STATUS")
	private boolean paymentStatus;


	public Payment(BigInteger sourceAccId, BigInteger destAccId, Double amount, String reason, boolean paymentStatus) {
		this.sourceAccId = sourceAccId;
		this.destAccId = destAccId;
		this.amount = amount;
		this.reason = reason;
		this.paymentStatus = paymentStatus;
	}

}

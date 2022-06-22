package com.payment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.Date;

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

	@JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
	@Column(name="DATE_CREATED")
	private Date dateCreated;


	public Payment(BigInteger sourceAccId, BigInteger destAccId, Double amount, String reason, boolean paymentStatus, Date dateCreated) {
		this.sourceAccId = sourceAccId;
		this.destAccId = destAccId;
		this.amount = amount;
		this.reason = reason;
		this.paymentStatus = paymentStatus;
		this.dateCreated = dateCreated;
	}

}

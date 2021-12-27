package com.softserve.kh05802java.osbb.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "person_account_debt_history")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class PersonalAccountDebtHistory {
    @ManyToOne
    @JoinColumn(name = "personal_accoubnt_id")
    private PersonalAccounts personalAccount;

    @ManyToOne
    @JoinColumn(name = "debt_history_id")
    private DebtHistory debtHistory;
}

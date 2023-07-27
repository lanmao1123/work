package com.team.dashuaibackend.model.domain.request;

import lombok.Data;

import java.io.Serializable;
@Data
public class AddNiaoRequest implements Serializable {
        private static final long serialVersionUID =3191241716373120793L;
        private double niao_amount;
        private double yali;
        private int hurt;
    }


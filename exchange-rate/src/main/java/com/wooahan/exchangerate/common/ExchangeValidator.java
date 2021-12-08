package com.wooahan.exchangerate.common;

import com.wooahan.exchangerate.common.exception.NotInputMonetaryException;
import com.wooahan.exchangerate.common.exception.WrongInputMonetaryException;

public class ExchangeValidator {
    public static void validator(String monetaryUnit) {
        if (isStringEmpty(monetaryUnit)) {
            throw new NotInputMonetaryException("화폐 단위가 입력되지 않았습니다.");
        }

        if (monetaryUnit.length() != 3) {
            throw new WrongInputMonetaryException("화폐 단위가 오입력되었습니다.");
        }
    }

    private static boolean isStringEmpty(String str) {
        return str == null || str.isEmpty();
    }
}

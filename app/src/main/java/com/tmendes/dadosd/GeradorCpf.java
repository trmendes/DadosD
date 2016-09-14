/*
 * Copyright (C) 2015-2016 The Food Restriction Project Team
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 3
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.tmendes.dadosd;

import java.util.Random;

class GeradorCpf {

    private final int[] cpf = new int[11];

    public String getNovoCpf() {
        Random rand = new Random();

        final int pLen = 9;
        final int sLen = 10;
        final int pPeso = 10;
        final int sPeso = 11;


        for (int i = 0; i < cpf.length - 2; ++i) {
            cpf[i] = rand.nextInt(9);
        }

        facaMagica(pPeso, pLen);
        facaMagica(sPeso, sLen);

        return this.toString();
    }

    private void facaMagica(int peso, int len) {
        int res_div, soma = 0;

        for (int i = 0; i < len; ++i) {
            soma += (cpf[i] * peso);
            --peso;
        }

        res_div = soma % 11;

        if (res_div < 2) {
            cpf[len] = 0;
        } else {
            cpf[len] = 11 - res_div;
        }
    }

    public String toString() {

        String sCpf = "";

        int ponto = 0, nPontos = 0;

        for (int aCpf : cpf) {
            sCpf += String.valueOf(aCpf);
            ++ponto;
            if (ponto == 3) {
                ++nPontos;
                if (nPontos == 3) {
                    sCpf += "-";
                } else {
                    sCpf += ".";
                }

                ponto = 0;
            }
        }

        return sCpf;
    }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.numerosprimos;

/**
 *
 * @author rod
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NumerosPrimos {

	public static void main(String[] args) {
		
		System.out.println("Por favor, escriba un número entre 5 y 1000:");
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		
		List<Integer> numerosPrimos = new ArrayList<>();

		for (int numeroChecar = 5; numeroChecar <= 1000; numeroChecar++) {
			boolean esPrimo = true;
			for (int factor = 2; factor <= numeroChecar/2; factor++) {
				if (numeroChecar % factor == 0) {
					esPrimo = false;
					break;
				}
			
			}
			if (esPrimo) {
				numerosPrimos.add(numeroChecar);
			}
		}
        /*System.out.println("Estos son");
        for (int number : numerosPrimos) {
            System.out.println(number);
        }*/

		boolean existe = numerosPrimos.contains(n);

		while(!existe) {
			n = n - 1;
			//System.out.println(n);
			boolean existeNuevo = numerosPrimos.contains(n);
			if(existeNuevo) {
				//System.out.println(existeNuevo);
				int p = numerosPrimos.indexOf(n);
				int valorP = numerosPrimos.get(p);
				int valorAnteriorP = numerosPrimos.get(p-1);
				int restaSuperExitosa = valorP - valorAnteriorP;
				boolean casoSuperExitoso = restaSuperExitosa == 2;
				while (restaSuperExitosa > 2) {
					p--;
					valorP = numerosPrimos.get(p);
					valorAnteriorP = numerosPrimos.get(p-1);
					//System.out.println(valor);
					//System.out.println(valorAnterior);
					int nRestaSuperExitosa = valorP - valorAnteriorP;
					casoSuperExitoso = nRestaSuperExitosa == 2;
					if (casoSuperExitoso) {
						//System.out.println("Ya la hicimos! Los números que buscas son: " + valor + " y "+ valorAnterior);
						break;
					} 
				}
				if(casoSuperExitoso) {
					System.out.println("Ya la hicimos! Los números que buscas son: " + valorP + " y "+ valorAnteriorP);
				}
				break;
			}
		}

		if (existe) {
 			int i = numerosPrimos.indexOf(n);
			//System.out.println(i);
            int valor = numerosPrimos.get(i);
            int valorAnterior = numerosPrimos.get(i-1);
			int restaExitosa = valor - valorAnterior;
			boolean casoExito = restaExitosa == 2;
			while (restaExitosa > 2) {
				i--;
				valor = numerosPrimos.get(i);
				valorAnterior = numerosPrimos.get(i-1);
				//System.out.println(valor);
				//System.out.println(valorAnterior);
				int nRestaExitosa = valor - valorAnterior;
				casoExito = nRestaExitosa == 2;
				if (casoExito) {
					//System.out.println("Ya la hicimos! Los números que buscas son: " + valor + " y "+ valorAnterior);
					break;
				} 
			}
			
			if (casoExito) {
				System.out.println("Ya la hicimos! Los números que buscas son: " + valor + " y "+ valorAnterior);
			} 
		}
	}
}


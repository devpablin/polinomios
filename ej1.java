package lab41016;

import java.util.Scanner;

public class ej1 {
	public static class polinomio{
		int coef,expo;
		polinomio sgte;
	}
	public static void main(String[] args) {
		polinomio a=null,b=null,c=null,d=null,e=null;
		int p;
		int op;
		do{
			System.out.println("1. Crear polinomio\n2. Listar polinomio\n3. Sumar polinomios\n4. Multiplicar por un escalar\n5. multiplicar polinomios\n6. Simplificar\n7. Ordenar");
			op=leer("su opcion?");
			switch(op){
			case 1:
				System.out.println("1. Polinomio A\n2. Polinomio B");
				p=leer("su opcion");
				switch(p){
				case 1:
					a=crear_poli(leer("grado del polinomio?"));
					break;
				case 2:
					b= crear_poli(leer("grado del polinomio?"));
					break;
				}
				break;
			case 2:
				System.out.println("1. Polinomio A\n2. Polinomio B");
				p=leer("su opcion");
				switch(p){
				case 1:
					listado(a);
					break;
				case 2:
					listado(b);
					break;
				}
				break;
			case 3:
				c=sumar(a,b);
				listado(c);
				break;
			case 4:
				d=multiplicacion_escalar(a, leer("escalar?"));
				listado(d);
				break;
			case 5:
				e=mult_polinomio(a, b);
				listado(e);
				break;
			case 6:
				System.out.println("1. Polinomio A\n2. Polinomio B\n3. Polinomio C\n4. Polinomio D\n5. Polinomio E");
				p=leer("su opcion");
				switch(p){
				case 1:
					simplificar(a);
					listado(a);
					break;
				case 2:
					simplificar(b);
					listado(b);
					break;
				case 3:
					simplificar(c);
					listado(c);
					break;
				case 4:
					simplificar(d);
					listado(d);
					break;
				case 5:
					simplificar(e);
					listado(e);
					break;
				}
				break;
			case 7:
				System.out.println("1. Polinomio A\n2. Polinomio B\n3. Polinomio C\n4. Polinomio D\n5. Polinomio E");
				p=leer("su opcion");
				switch(p){
				case 1:
					a=ordenar(a);
					listado(a);
					break;
				case 2:
					a=ordenar(b);
					listado(b);
					break;
				case 3:
					a=ordenar(c);
					listado(c);
					break;
				case 4:
					a=ordenar(d);
					listado(d);
					break;
				case 5:
					a=ordenar(e);
					listado(e);
					break;
				}
				break;
			}
		}while(op!=8);
	}
	public static int leer (String msg){
		Scanner lee = new Scanner(System.in);
		System.out.println(msg);
		return lee.nextInt();
	}
	public static polinomio crear_poli(int n){
		polinomio p = null,aux;
		int t;
		for (int i = 0; i <= n; i++) {
			t=leer("coeficiente de x"+i);
			if (t!=0) {
				aux=new polinomio();
				aux.coef=t;
				aux.expo=i;
				aux.sgte=p;
				p=aux;
			}
			
		}
		return p;
	}
	public static void listado(polinomio z){
		while(z!=null){
			System.out.print(z.coef+"x"+z.expo+"+");
			z=z.sgte;
		}
		System.out.println();
	}
	public static polinomio sumar(polinomio a, polinomio b){
		polinomio c=null;
		while(a!=null){
			c=addcola(c,a.coef,a.expo);
			a=a.sgte;
		}
		while(b!=null){
			c=addcola(c,b.coef,b.expo);
			b=b.sgte;
		}
		simplificar(c);
		return c;
	}
	public static int contar (polinomio z){
		int c=0;
		while(z!=null){
			c++;
			z=z.sgte;
		}
		return c;
	}
	public static polinomio addcola (polinomio x,int coef, int exp){
		polinomio c;
		polinomio nuevo=new polinomio();
		nuevo.coef=coef;
		nuevo.expo=exp;
		nuevo.sgte=null;
		if (x==null) {
			x=nuevo;
		}else{
			c=x;
			while(c.sgte!=null){
				c=c.sgte;
			}
			c.sgte=nuevo;
		}
		return x;
	}
	public static polinomio addcab (polinomio x, int c, int ex){
		polinomio aux= new polinomio();
		aux.sgte=x;
		aux.coef=c;
		aux.expo=ex;
		x=aux;
		return aux;
	}
	public static void simplificar(polinomio z){
		polinomio a=z.sgte;
		polinomio c=z;
		while(z!=null){
			a=z.sgte;
			c=z;
			while(a!=null){
				if(z.expo==a.expo){
					z.coef=z.coef+a.coef;
					c.sgte=a.sgte;
					a=c;
				}
				c=a;
				a=a.sgte;
			}
			z=z.sgte;
		}
	}
	public static polinomio multiplicacion_escalar(polinomio p,int esc){
		polinomio c=p;
		polinomio d=null;
		while(c!=null){
			c.coef=c.coef*esc;
			d=addcola(d,c.coef,c.expo);
			c=c.sgte;
		}
		return d;
	}
	public static polinomio mult_polinomio(polinomio p, polinomio q){
		polinomio r=null,a1=p,a2=q;
		while(a1!=null){
			a2=q;
			while(a2!=null){
				r=addcola(r, a1.coef*a2.coef, a1.expo+a2.expo);
				System.out.println(a1.coef*a2.coef+"  "+a1.expo+a2.expo);
				a2=a2.sgte;
			}
			a1=a1.sgte;
		}
		return r;
	}
	public static polinomio ordenar(polinomio cab){
		polinomio p, q;
		for (int i = contar(cab); i > 1; i--) {
			p=cab;
			q=p.sgte;
			for (int j = 1; j < i; j++) {
				if(p.expo<q.expo){
					int aux1=q.expo;
					int aux2=q.coef;
					q.expo=p.expo;
					q.coef=p.coef;
					p.expo=aux1;
					p.coef=aux2;
				}
				p=p.sgte;
				q=q.sgte;
			}
		}
		return cab;
	}
}

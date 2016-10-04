import java.util.Scanner;


public class ejemplo1 {
	public static class polinomio{
		int coef, expo;
		polinomio sgte;
	}
	public static void main(String []args){
		polinomio k = null;
		int g;
		do{
			g=leer("grado del polinomio?");
		}while(g<=0);
		k=crear_poli(g);
		listado(k);
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
			System.out.println(z.coef+"x"+z.expo+"+");
			z=z.sgte;
		}
	}
	public static void derivar(polinomio p){
		polinomio c;
		c=p;
		while(c!=null){
			c.coef=c.coef*c.expo;
			c.expo--;
			c=c.sgte;
		}
	}
	public static void integrar (polinomio p){
		polinomio a;
		a=p;
		while(a!=null){
			a.coef=(a.coef/(a.expo+1));
			a.expo++;
			a=a.sgte;
		}
	}
	public static void multiplicacion_escalar(polinomio p,int esc){
		polinomio c=p;
		while(c!=null){
			c.coef=c.coef*esc;
			c=c.sgte;
		}
	}
	public static polinomio mult_polinomio(polinomio p, polinomio q){
		polinomio r=null;
		while(p!=null){
			while(q!=null){
				r=addcola(r, p.coef*q.coef, p.expo+q.expo);
				q=q.sgte;
			}
			p=p.sgte;
		}
		return r;
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
	//tarea ordenar y quitar ceros, division entre dos polinomios
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
}

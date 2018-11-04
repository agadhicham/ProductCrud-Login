package org.m2i;

import org.m2i.dao.ProduitREpository;
import org.m2i.entities.Produit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMvcApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(SpringMvcApplication.class, args);
		ProduitREpository produitREpository=ctx.getBean(ProduitREpository.class);
		produitREpository.save(new Produit("LENOVO", 3000, 9));
		produitREpository.save(new Produit("HPhp", 4000, 3));
		produitREpository.save(new Produit("TINLPAD", 4500, 4));
		
		produitREpository.findAll().forEach(p->System.out.println(p.getDesignation()));

	}
}

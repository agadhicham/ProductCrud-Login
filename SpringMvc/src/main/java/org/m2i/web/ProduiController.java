package org.m2i.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.m2i.dao.ProduitREpository;
import org.m2i.entities.Produit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProduiController {
	@Autowired
	private ProduitREpository produitREpository;
	@RequestMapping(name = "/index")
	public String index(Model model, 
			@RequestParam(name = "page", defaultValue = "0") int p,
			@RequestParam(name = "size", defaultValue = "4") int s,
			@RequestParam(name = "motCle", defaultValue = "")String mc) {
		Page<Produit> page = produitREpository.cherche("%"+mc+"%",new PageRequest(p, s));
		int[] pages = new int[page.getTotalPages()];
		model.addAttribute("size", s);
		model.addAttribute("pagedef", p);
		model.addAttribute("pages", pages);
		model.addAttribute("listprd", page);
		model.addAttribute("motCle", mc);
		return "produits";
	}
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String delete(Long id, String motCle,int page,int size ) {
		produitREpository.deleteById(id);
		
		return "redirect:/index?page="+page+"&size="+size+"&page="+page+"&motCle="+motCle;
		
	}
	@RequestMapping(value="/form",method=RequestMethod.GET)
	public String formProduit(Model model) {
		model.addAttribute("produit",new Produit());
		return "FormProdui";
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	//@Valid cherche s'il y a des condition sur les attributs entityProduit
	//si oui il sont stocké dand BindingResult sinon passe a sauvgarder ml'element(objet) produit
	public String save(Model model,@Valid Produit produit, BindingResult bindingResult ) {
		if(bindingResult.hasErrors())
			return "FormProdui";
		produitREpository.save(produit);
		//model.addAttribute("produit", produit);
		return "details";
	}
	
	
	@RequestMapping(value="/edit",method=RequestMethod.GET)
	public String edit(Model model,Long id) {
Produit p= produitREpository.findById(id).get();
		model.addAttribute("produit", p);
		return "EditProduit";
	}
}

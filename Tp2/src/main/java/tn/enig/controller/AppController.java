package tn.enig.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import tn.enig.dao.IDepartement;
import tn.enig.dao.IMateriel;
import tn.enig.model.Departement;

import tn.enig.model.Materiel;

@Controller
public class AppController {
	@Autowired
      IMateriel Imat;
	@Autowired
      IDepartement Idep;
      
      
	public AppController(IMateriel imat, IDepartement idep) {
		super();
		Imat = imat;
		Idep = idep;
	}
      
	@GetMapping("/")
	public String home(Model m) {
		
		
		return "home";
		
		
	}  
	
	
	
	
	@GetMapping("/Departement")
	public String dept(Model m) {
		
		List<Departement> Ld=Idep.findAll();
		m.addAttribute("ld", Ld);
		return "departements";
		
		
	}
	
	@GetMapping("/Materiel/{id}")
	public String Mat(Model m,@PathVariable int id) {
		
		List<Materiel> Lm=Imat.findAllByDep(id);
		m.addAttribute("lm",Lm);
		return "ListeMaterielsDepartement";				
	}
      
    @GetMapping("delete/{id}")
    public String Del(Model m,@PathVariable int id) {
    	
    	Imat.delete(id);
    	
		return "redirect:/Departement";
    	
    }
	
    
    @GetMapping("/addMateriel")
	public String AjoutMat(Model model) {
		
		Materiel m=new Materiel();
		model.addAttribute("mat",m);
		List<Departement> Ld=Idep.findAll();
		model.addAttribute("ld", Ld);
		
		return "Ajout_Materiel";
		
		
		
	}
	
	
	    @PostMapping("/saveMateriel")
		public String Savemat(Model model , @ModelAttribute("mat") Materiel m) {
	    	Imat.save(m);
	    	return "redirect:/Departement";
	    	
			
			
	   }
	
}

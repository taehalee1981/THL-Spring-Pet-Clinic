package guru.springframework.thlspringpetclinic.controllers;

import guru.springframework.thlspringpetclinic.model.Owner;
import guru.springframework.thlspringpetclinic.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

@RequestMapping("/owners")
@Controller
public class OwnerController {

    private static final String VIEWS_OWNER_CREATE_OR_UPDATE_FORM = "owners/createOrUpdateOwnerForm";
    private final OwnerService ownerService;

    // @autowired automaticamente pelo String framework8
    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping({"/find"})
    public String findOwners(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return "owners/findOwners";
    }

    @GetMapping
    public String processFindForm(Owner owner, BindingResult result, Model model) {
        //allow parameterless GET request for /owners to return all records.
        if (owner.getLastName() == null) {
            owner.setLastName("");
        }

        List<Owner> results = ownerService.findAllByLastNameLike("%"+owner.getLastName()+"%");

        if (results.isEmpty()) {
            result.rejectValue("lastName", "notFound", "not found");
            return "owners/findOwners";
        }
        else if (results.size() == 1) {
            // 1 owner found
            owner = results.get(0);
            return "redirect:/owners/" + owner.getId();
        }
        else {
            // multiple owners found
            model.addAttribute("listOwners", results);
            return "owners/ownersList";
        }
    }

    @GetMapping("/{ownerId}")
    public ModelAndView showOwner(@PathVariable("ownerId") Long ownerId) {
        //Returning view
        ModelAndView mav = new ModelAndView("owners/ownerDetails");
        mav.addObject(ownerService.findById(ownerId));
        return mav;
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("owner", Owner.builder().build());
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Validated Owner owner, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else {
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }

    @GetMapping("/{ownerId}/edit")
    public String initUpdateOwnerForm(@PathVariable Long ownerId, Model model) {
        model.addAttribute(ownerService.findById(ownerId));
        return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{ownerId}/edit")
    public String processUpdateOwnerForm(@Validated Owner owner, BindingResult result,
                                         @PathVariable Long ownerId) {
        if (result.hasErrors()) {
            return VIEWS_OWNER_CREATE_OR_UPDATE_FORM;
        }
        else {
            owner.setId(ownerId);
            Owner savedOwner = ownerService.save(owner);
            return "redirect:/owners/" + savedOwner.getId();
        }
    }
}

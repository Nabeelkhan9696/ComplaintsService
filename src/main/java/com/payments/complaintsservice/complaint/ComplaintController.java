package com.payments.complaintsservice.complaint;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class ComplaintController {

    private final ComplaintService service;

    public ComplaintController(ComplaintService service) {
        this.service = service;
    }

    @GetMapping({"/", "/complaints"})
    public String complaints(Model model) {
        model.addAttribute("complaint", new Complaint());
        model.addAttribute("complaints", service.findAll());
        return "complaints";
    }

    @PostMapping("/complaints")
    public String submitComplaint(
            @Valid @ModelAttribute("complaint") Complaint complaint,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            Model model) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("complaints", service.findAll());
            return "complaints";
        }

        service.submit(complaint);
        redirectAttributes.addFlashAttribute("message", "Complaint submitted successfully.");
        return "redirect:/complaints";
    }
}

package com.taco.tacocloud.controller;

import com.taco.tacocloud.entity.TacoOrder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.batch.BatchTransactionManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@Slf4j
@RequestMapping("/orders")
@SessionAttributes("tacoOrder")
public class OrderController {
    @GetMapping("/current")
    public String orderForm() {
        return "oderForm";
    }

    @PostMapping
    public String processOrder(
            @ModelAttribute TacoOrder order,
                               SessionStatus sessionStatus) {
        log.info("Order submitted: {}", order);
        sessionStatus.setComplete();
        return "redirect:/";
    }
}

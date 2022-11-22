package com.example.pedido.controller;

import com.example.pedido.entity.Cliente;
import com.example.pedido.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pedido/v1")
public class ClienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @PostMapping
    public Cliente create(@RequestBody Cliente cliente){
        Cliente clienteSaved = clienteRepository.save(cliente);
        return clienteSaved;
    }

    @GetMapping("/{id}")
    @ResponseBody
    public Optional<Cliente> getClienteById(@PathVariable Long id){
        Optional<Cliente> clienteReturned = clienteRepository.findById(id);
        return clienteReturned;
    }


    @DeleteMapping("/{id}")
    public String deleteClienteById(@PathVariable Long id){
        try{
            Optional<Cliente> cliente = Optional.of(clienteRepository.getById(id));
            if (cliente != null){
                clienteRepository.deleteById(id);
                return "Cliente de id " + id + " foi deletado com sucesso!!";
            }else {
                throw new Exception("Cliente inexistente!");
            }
        }catch (Exception e){
            e.printStackTrace();
            return "O Cliente de id " + id + " não existe para ser deletado";
        }
    }

    @GetMapping
    public List<Cliente> clienteList(){
        return clienteRepository.findAll();
    }


    @PutMapping("/atualize/{id}")
    public String updateClienteById(@RequestBody@Valid Cliente cliente, @PathVariable Long id){
        Optional<Cliente> clienteAntigo = clienteRepository.findById(id);
        if(clienteAntigo.isPresent()){
            Cliente clientes = clienteAntigo.get();
            cliente.setParcelas(cliente.getParcelas());
            clienteRepository.save(cliente);
            return "CLiente de id " + id +" teve suas parcelas alteradas";
        }else {
            return "Cliente de Id " + id + " nao existe";
         }
    }






}

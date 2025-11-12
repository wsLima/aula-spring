package br.com.wsystechnologies.lojaroupa.controller;

import br.com.wsystechnologies.lojaroupa.model.Produto;
import br.com.wsystechnologies.lojaroupa.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*") // permite testes com front-end
public class ProdutoController {

    private final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    public ResponseEntity<List<Produto>> listarTodos() {
        return ResponseEntity.ok(produtoService.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(produtoService.buscarPorId(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Produto>> buscarPorNome(@RequestParam String nome) {
        return ResponseEntity.ok(produtoService.buscarPorNome(nome));
    }

    @PostMapping
    public ResponseEntity<Produto> criar(@Valid @RequestBody Produto produto) {
        Produto novoProduto = produtoService.salvar(produto);
        return ResponseEntity.ok(novoProduto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @Valid @RequestBody Produto produto) {
        Produto atualizado = produtoService.atualizar(id, produto);
        return ResponseEntity.ok(atualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }
}

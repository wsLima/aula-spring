package br.com.wsystechnologies.lojaroupa.service;

import br.com.wsystechnologies.lojaroupa.exception.ResourceNotFoundException;
import br.com.wsystechnologies.lojaroupa.model.Produto;
import br.com.wsystechnologies.lojaroupa.repository.ProdutoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Produto não encontrado com ID: " + id));
    }

    public List<Produto> buscarPorNome(String nome) {
        return produtoRepository.findByNomeContainingIgnoreCase(nome);
    }

    public Produto salvar(Produto produto) {
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setDescricao(produtoAtualizado.getDescricao());
        produto.setPreco(produtoAtualizado.getPreco());
        produto.setCategoria(produtoAtualizado.getCategoria());
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        Produto produto = buscarPorId(id);
        produtoRepository.delete(produto);
    }
}

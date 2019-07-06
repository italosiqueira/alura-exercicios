class ProdutosController < ApplicationController
    def index
        @produtos_por_nome = Produto.order(:nome)
        @produtos_por_preco = Produto.order(:preco).reverse_order.limit 2
    end

    def create
    end
end

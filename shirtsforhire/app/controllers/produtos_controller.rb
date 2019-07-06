class ProdutosController < ApplicationController
    def index
        @produtos_por_nome = Produto.order(:nome)
        @produtos_por_preco = Produto.order(:preco).reverse_order.limit 2
    end

    def create
        entrada = params.require(:produto).permit :nome, :descricao, :quantidade, :preco
        produto = Produto.new entrada
        produto.save
    end

    def destroy
        id = params[:id]
        Produto.destroy id
        redirect_to root_url
    end
end

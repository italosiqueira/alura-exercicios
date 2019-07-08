class ProdutosController < ApplicationController
    def index
        @produtos_por_nome = Produto.order(:nome)
        @produtos_por_preco = Produto.order(:preco).reverse_order.limit 2
    end

    def new
        @produto = Produto.new
    end

    def create
        entrada = params.require(:produto).permit :nome, :descricao, :quantidade, :preco
        @produto = Produto.new entrada
        if @produto.save
            flash[:notice] = "Novo produto cadastrado com sucesso!"
            redirect_to root_url
        else
            render :new
        end
    end
    
    def destroy
        id = params[:id]
        Produto.destroy id
        redirect_to root_url
    end

    def busca
        @nome_busca = params[:nome]
        @resultados = Produto.where "nome LIKE ?", "%#{@nome_busca}%"
    end
end

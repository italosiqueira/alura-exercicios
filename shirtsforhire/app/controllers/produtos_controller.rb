class ProdutosController < ApplicationController
    
    before_action :set_produto, only: [:edit, :destroy, :update]

    def index
        @produtos_por_nome = Produto.order(:nome)
        @produtos_por_preco = Produto.order(:preco).reverse_order.limit 2
    end

    def new
        @produto = Produto.new
        renderiza :new
    end
    
    def create
        @produto = Produto.new produto_params
        if @produto.save
            flash[:notice] = "Novo produto cadastrado com sucesso!"
            redirect_to root_url
        else
            renderiza :new
        end
    end
    
    def edit
        renderiza :edit
    end

    def update
        if @produto.update produto_params
            flash[:notice] = "Produto atualizado com sucesso!"
            redirect_to root_url
        else
            renderiza :edit
        end 
    end
    
    def destroy
        @produto.destroy
        redirect_to root_url
    end

    def busca
        @nome_busca = params[:nome]
        @resultados = Produto.where "nome LIKE ?", "%#{@nome_busca}%"
    end

    private

    def set_produto
        id = params[:id]    #busca o parâmetro "id"
        @produto = Produto.find(id)    #procura o produto
    end
    
    def produto_params
        params.require(:produto).permit :nome, :descricao, :quantidade, :preco, :departamento_id
    end

    def renderiza visao
        @departamentos = Departamento.all
        render visao
    end
end

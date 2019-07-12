class ProdutosController < ApplicationController
    def index
        @produtos_por_nome = Produto.order(:nome)
        @produtos_por_preco = Produto.order(:preco).reverse_order.limit 2
    end

    def new
        @produto = Produto.new
        @departamentos = Departamento.all
    end
    
    def create
        entrada = params.require(:produto).permit :nome, :descricao, :quantidade, :preco, :departamento_id
        @produto = Produto.new entrada
        if @produto.save
            flash[:notice] = "Novo produto cadastrado com sucesso!"
            redirect_to root_url
        else
            @departamentos = Departamento.all
            render :new
        end
    end
    
    def edit
        id = params[:id]    #busca o parâmetro "id"
        @produto = Produto.find(id)    #procura o produto
        @departamentos = Departamento.all
        render :new  #queremos renderizar a view do "new", pois é no formulário que faremos as modificações
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

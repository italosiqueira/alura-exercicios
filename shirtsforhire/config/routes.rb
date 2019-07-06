Rails.application.routes.draw do
  # For details on the DSL available within this file, see http://guides.rubyonrails.org/routing.html
  get "produtos" => "produtos#index"
  get "produtos/new" => "produtos#new"
  post "produtos" => "produtos#create"
  get "produtos/:id/remove" => "produtos#destroy"
  root "produtos#index"
end

#include "carro.h"
#include <stdlib.h>
#include <stdio.h>

struct _carro{
  int placa;
  int horaChegada;
  int horaSaida;
  float desconto;
};

Carro *carro_criar(int placa, int horaChegada, int horaSaida, float desconto){
  Carro *carro = (Carro*)malloc(sizeof(Carro));
  carro->placa = placa;
  carro->horaChegada = horaChegada;
  carro->horaSaida = horaSaida;
  carro->desconto = desconto;

  return carro;
}

void carro_deletar(Carro* carro){
  free(carro);
}

int carro_get_placa(Carro *carro){
  return carro->placa;
}

int carro_get_hChegada(Carro *carro){
  return carro->horaChegada;
}

int carro_get_hSaida(Carro *carro){
  return carro->horaSaida;
}

float carro_get_desconto(Carro *carro){
  return carro->desconto;
}

void carro_imprimir(Carro *carro){
    float valor = (carro->horaSaida-carro->horaChegada)*3;
    printf("Carro %d - R$%.2f\n", carro->placa, valor-(valor*carro->desconto));
}

void carro_set_desconto(Carro *carro, float _desconto){
    carro->desconto = _desconto;
}

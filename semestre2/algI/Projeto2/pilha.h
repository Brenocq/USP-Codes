#ifndef PILHA_H
#define PILHA_H

#include "carro.h"
#include <stdbool.h>

typedef struct _pilha Pilha;

Pilha* pilha_criar();
void pilha_deletar(Pilha **p);

Carro* pilha_inserir(Pilha *p);
Carro* pilha_remover(Pilha *p);

bool pilha_vazia(Pilha *p);
bool pilha_cheia(Pilha *p);

Carro* pilha_topo(Pilha *p);

void pilha_checkout(Pilha *p, int horaSaida);


#endif// PILHA_H

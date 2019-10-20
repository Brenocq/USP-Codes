#include "pilha.h"
#include <stdlib.h>
#include <stdio.h>

#define MAX 50

struct _item{
  Carro *carro;
  struct _item *prev;
};

struct _pilha{
  Item *topo;
  int tamanho;
};

Pilha* pilha_criar(){
  Pilha *p = (Pilha *)malloc(sizeof(Pilha));
  if(p != NULL){
    p->topo = NULL;
    p->tamanho = 0;
  }
  return p;
}

void pilha_deletar(Pilha **p){
  Item *curr = (*p)->topo;
  while(curr != NULL){
    Item *prox = curr->prev;
    free(curr);
    curr = next;
  }
  free(*p);
  *p = NULL;
}

Item* item_criar(Carro *c){
    Item* item = (Item*)malloc(sizeof(Item));
    item->carro = c;
    item->prev = NULL;
    return item;
}

bool pilha_inserir(Pilha *p, Carro *c){
  if(pilha_cheia(p)) return FALSE;
  Item *i = item_criar(c);
  if(i != NULL){
    i->prev = p->topo;
    p->tamanho++;
    p->topo = i;
    return TRUE;
  }
  return FALSE;
}

Carro* pilha_remover(Pilha *p){
  if(fila_vazia(p)) return NULL;
  Item *i = p->topo;
  p->topo = p->topo->prev;
  i->prev = NULL;
  p->tamanho--;
  return i->carro;
}

bool pilha_vazia(Pilha *p){
  return (p->tamanho == 0);
}

bool pilha_cheia(Pilha *p){
  return (p->tamanho == MAX);
}

Carro* pilha_topo(Pilha *p){
  if(pilha_vazia(p)) return NULL;
  return p->topo->carro;
}

void pilha_checkout(Pilha *p, int horaSaida){
  while(pilha_topo(p)->horaSaida>=horaSaida){
      carro_imprimir(curr->carro);//TODO fazer o que pede
      pilha_remover(p);
  }
}

bool pilha_busca(Pilha *p, int placa){
  Item *curr = p->topo;
  while(curr != NULL){
    if(curr->carro->placa == placa) return TRUE;
    curr = curr->prev;
  }
  return FALSE;
}

import { Keynote } from "./keynote.model";

export interface Review {
  id: number;
  date: Date;
  texte: string;
  stars: number;
}

export interface Conference {
  id: number;
  titre: string;
  type: string;
  date: Date;
  duree: number;
  nombreInscrits: number;
  score: number;
  keynoteId: number;
  keynote?: Keynote;
  reviews?: Review[];
}

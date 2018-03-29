package com.tolbier.algorithms.commons;

import java.util.ArrayList;
import java.util.List;

public class Vertex<T> {
	
    long id;
    private T data;
    private List<Edge<T>> inEdges = new ArrayList<>();
    private List<Edge<T>> edges = new ArrayList<>();
    private List<Vertex<T>> adjacentVertex = new ArrayList<>();
    
    public Vertex(long id){
        this.id = id;
    }
    
    public long getId(){
        return id;
    }
    
    public void setData(T data){
        this.data = data;
    }
    
    public T getData(){
        return data;
    }
    
    public void addAdjacentVertex(Edge<T> e, Vertex<T> v){
        edges.add(e);
        e.getVertex2().addInEdge(e);
        adjacentVertex.add(v);
    }
    private void addInEdge(Edge<T> inEdge) {
    	inEdges.add(inEdge);
    }
    public String toString(){
        return String.valueOf(id);
    }
    
    public List<Vertex<T>> getAdjacentVertexes(){
        return adjacentVertex;
    }
    
    public List<Edge<T>> getEdges(){
        return edges;
    }
    public List<Edge<T>> getInEdges(){
        return inEdges;
    }
    
    public int getDegree(){
        return edges.size();
    }

    public int getInDegree(){
        return inEdges.size();
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Vertex other = (Vertex) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

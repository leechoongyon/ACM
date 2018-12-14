package codingInterview.treeAndGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *	1. Graph 생성. Dependency 와 child 를 가지고 있도록
 *		1.1 Graph 자료 구조 중요
 *		1.2 Graph 는 Node List 를 가지고 있고,
 *		1.3 Node 는 Child 를 통해 종속 관계를 가지고 있다.
 *		1.4 Node 내부에서는 dependency 라는 변수를 통해 종속 관계 개수를 나타냄. (ROOT 찾기 위함)
 *	2. Dependency 없는 것부터 제거
 *	3. 1,2 계속해서 반복. 
 *
 *	
 */

public class Question4g
{
	public static class Node
	{
		private List<Node> childList = new ArrayList<Node>();
		private String name;
		private int dependency = 0;
		
		public Node(String name)
		{
			this.name = name;
		}

		public List<Node> getChild()
		{
			return childList;
		}
		
		public String getName()
		{
			return this.name;
		}
		
		public void addChild(Node node)
		{
			childList.add(node);
			node.dependency++;
		}

		@Override
		public String toString()
		{
			return "Node [dependencyList=" + childList + ", name=" + name + ", dependency=" + dependency + "]";
		}
	}
	
	public static class Graph
	{
		private List<Node> nodeList = new ArrayList<Node>();
		private Map<String, Node> map = new HashMap<String, Node>();
		
		public void addNode(String nodeName)
		{
			if ( !map.containsKey(nodeName))
			{
				Node node = new Node(nodeName);
				nodeList.add(node);
				map.put(nodeName, node);
			}
		}
		
		public void addDependency(String first, String second)
		{
			Node firstNode = map.get(first);
			Node secondNode = map.get(second);
			firstNode.addChild(secondNode);
		}
		
		public List<Node> getNodes()
		{
			return nodeList;
		}

		@Override
		public String toString()
		{
			return "Graph [nodeList=" + nodeList + ", map=" + map + "]";
		}
	}
	
	public static Graph buildGraph(String projects[], String dependencies[][])
	{
		Graph graph = new Graph();
		for (String project : projects)
		{
			graph.addNode(project);
		}
		
		for (int i = 0 ; i < dependencies.length ; i++)
		{
			String first = dependencies[i][0];
			String second = dependencies[i][1];
			graph.addDependency(first, second);
		}
		return graph;
	}
	
	public static String[] extractOrderedProjects(Graph graph)
	{
		List<Node> list = null;
		String ordered[] = new String[list.size()];
		int offset = 0;
		
		while (true)
		{
			list = graph.getNodes();
			for (int i = 0 ; i < list.size() ; i++)
			{
				/** 1. dependency 가 없는 node 부터 추출 */
				if (list.get(i).dependency == 0)
				{
					ordered[offset++] = list.get(i).getName();
					
					/** 2. 위에서 추출한 node 의 child 들의 dependency-- */
					List<Node> childList = node.getChild();
					for (Node child : childList)
						child.dependency--;
				}
			}
		}
		
		
		
		
	}
	
	
	/**
	 * 	1. 그래프 생성
	 * 	2. 그래프를 통해 ordered projects 를 추출.
	 * 		2.1 dependency 가 없는 project 부터 추출
	 * 		2.2 해당 project 를 참조하고 있는 project 의 dependency--
	 * 		2.3 2.1~2.2 반복
	 * 	3. 순환을 어떻게 감지할지 고민 
	 */
	public static void main(String[] args)
	{
		String projects[] = {"a", "b", "c", "d", "e", "f"};
		String dependencies[][] = 
			{{"a", "d"}, {"f", "b"}, {"b", "d"}, {"f", "a"}, {"d", "c"}};
		Graph graph = buildGraph(projects, dependencies);
		String ordered[] = extractOrderedProjects(graph);
	}
}

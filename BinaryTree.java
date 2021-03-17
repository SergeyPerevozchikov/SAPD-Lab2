import java.util.Date;
import java.util.ArrayList;
//import java.io;
import java.util.Arrays;
import java.util.Random;

public class BinaryTree
{
	
	private Integer root;
	private BinaryTree leftTree;
	private BinaryTree rightTree;
	
	public void search(int num)
	{
		if(this.root == null)
		{
			System.out.println("Tree doesn't contain " + Integer.toString(num));
		}
		else
		{
			if(this.root == num)
			{
				System.out.println();
			}
			if(num < this.root)
			{
				if(this.leftTree == null)
				{
					System.out.println("Tree doesn't contain " + Integer.toString(num));
				}
				else
				{
					System.out.print("L");
					this.leftTree.search(num);
				}
			}
			if(num > this.root)
			{
				if(this.rightTree == null)
				{
					System.out.println("Tree doesn't contain " + Integer.toString(num));
				}
				else
				{
					System.out.print("R");
					this.rightTree.search(num);
				}
			}
		}
		
	}
	
	public void add(int num)
	{
		if(this.root == null)
		{
			this.root = num;
		}
		if(num < this.root)
		{
			if(this.leftTree == null)
			{
				this.leftTree = new BinaryTree();
			}
			this.leftTree.add(num);
		}
		if(num > this.root)
		{
			if(this.rightTree == null)
			{
				this.rightTree = new BinaryTree();
			}
			this.rightTree.add(num);
		}
	}
	
	public int getRoot()
	{
		return this.root;
	}
	
	public BinaryTree getLeft()
	{
		return this.leftTree;
	}
	public BinaryTree getRight()
	{
		return this.rightTree;
	}
	
	public void setLeft(BinaryTree left)
	{
		this.leftTree = left;
	}
	
	public void setRight(BinaryTree right)
	{
		this.rightTree = right;
	}
	
	public void delete(int num)
	{
		if(this.root == num)
		{
			
			if(this.leftTree == null && this.rightTree == null)
			{
				this.root = null;
			}
			if(this.leftTree != null && this.rightTree == null)
			{
				this.root = leftTree.getRoot();
				this.leftTree = leftTree.getLeft();
				this.rightTree = leftTree.getRight();
			}
			if(this.leftTree == null && this.rightTree != null)
			{
				this.root = rightTree.getRoot();
				this.leftTree = rightTree.getLeft();
				this.rightTree = rightTree.getRight();
			}
			if(this.leftTree != null && this.rightTree != null)
			{
				
					this.root = leftTree.getRoot();
					this.leftTree = leftTree.getLeft();
					BinaryTree right = this.getRight();
					this.rightTree = leftTree.getRight();
					this.rightTree.setRight(right);
				
			}
		}
		if(this.root != null)
		{
			if(num < this.root)
			{
				if(this.leftTree == null)
				{
					System.out.println("Tree doesn't contain " + Integer.toString(num));
				}
				else
				{
					this.leftTree.delete(num);
				}
				
			}
			if(this.root != null && num > this.root)
			{
				if(this.rightTree == null)
				{
					System.out.println("Tree doesn't contain " + Integer.toString(num));
				}
				else
				{
					this.rightTree.delete(num);
				}
			
			}
		}
		
	}
	
	public static void main(String[] args)
	{
		BinaryTree tree = new BinaryTree();
		tree.add(16);
		tree.add(5);
		tree.add(32);
		tree.add(89);
		tree.add(2);
		tree.add(11);
		tree.add(7);
		tree.add(64);
		tree.search(64);
		tree.search(2);
		tree.delete(32);
		tree.search(89);
	}
}